package com.lpc.View;

import com.lpc.controller.*;
import com.lpc.pojo.*;
import com.lpc.util.IDUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 普通用户页面
 */
public class NormalUserView {
    static UserController userController = new UserController();
    static ProductsController productsController = new ProductsController();
    static Cart_itemsController controller = new Cart_itemsController();
    static OrdersController ordersController = new OrdersController();
    static PaymentController paymentController = new PaymentController();
    private static Scanner scan = new Scanner(System.in);

    /**
     * 显示普通用户首页的操作信息
     */
    public static void showUsersMessage(Users users) {
        boolean isLoop = true;
        while (isLoop) {
            System.out.println("********欢迎进入用户首页*************");
            System.out.println("********1.显示所有商品信息*************");
            System.out.println("********2.根据关键字搜索商品信息*************");//++根据商品编号查找商品
            System.out.println("********3.进入购物车*************");
            System.out.println("********4.查看个人订单*************");
            System.out.println("********5.退   出*************");
            System.out.println("*********************");
            System.out.println("*********请选择输入:************");
            int num = scan.nextInt();
            int uid = users.getUser_id();
            ProductsController productsController = new ProductsController();
            Cart_itemsController controller = new Cart_itemsController();
            OrdersController ordersController = new OrdersController();
            switch (num) {
                case 1:
                    buyProducts(users);

                    break;
                case 2:
                    System.out.println("请输入关键字");
                    String des = scan.next();
                    productsController.selectBydes(des);
                    break;
                case 3:
                    showcartitems(users);
                    break;
                case 4:
                    ordersController.selectByuid(uid);
                case 5:
                    isLoop = false;
                default:
                    break;


            }
        }
    }

    public static void buyProducts(Users users) {
        boolean isLoop = true;
        while (isLoop) {
            // 显示商品信息
            List<Products> products = productsController.showAllproducts();
            System.out.println("商品编号\t\t名称\t\t\t单价\t\t\t库存\t\t\t类型\t\t\t商品描述");
            for (Products p : products) {
                System.out.println(p.getProduct_id() + "\t\t\t" + p.getName() + "\t\t" + p.getPrice() + "\t\t" + p.getStock()
                        + "\t\t" + p.getCategories().getCname() + "\t\t\t" + p.getDescription());
            }
            System.out.println("根据商品编号进行购买:");
            Scanner scanner = new Scanner(System.in);
            String byeId = scanner.nextLine(); // 输入商品编号
            // 判断byeId不能null并且不能是空串
            if (byeId != null && !byeId.trim().isEmpty()) {
                // 根据编号查询商品信息
                Products product = productsController.findByid(byeId);
                // 判断当前商品是否存在
                if (product != null) { // 表示商品存在
                    System.out.println("请输入购买数量:");
                    int byeNum = scan.nextInt();
                    // 判断库存是否充足
                    if (byeNum > 0 && byeNum <= product.getStock()) { // 表示库存充足
                        System.out.println("1.直接购买商品");
                        System.out.println("2.加入购物车");
                        System.out.println("3.退出");
                        System.out.println("请选你要进行的操作:");
                        int inputNum = scan.nextInt();
                        if (inputNum == 1) {
                            // 直接购买的操作

                            //直接凭借购物车  订单方法
                            System.out.println("商品已直接购买!");
                            insertCartItems(users, product, byeNum); // 调用添加购物车方法
                            productsController.updateStock(product.getProduct_id(), byeNum);
                            Cart_itemsController controller = new Cart_itemsController();
                            List<Cart_items> list = controller.showAllcart_items(users.getUser_id());
                            if (list != null && list.size() > 0) {
                                Map<String, Object> map = new HashMap<>();
                                map = generateOrderandOrderItems(users, controller, list);
                                //付款
                                pay(users, (int) map.get("pid"),list);
                            }

                            //清空用户购物车
                            for (Cart_items c : list
                            ) {
                                controller.deleteBycart_item_id(c);
                            }

                            //
                        } else if (inputNum == 2) { // 加入购物车操作
                            insertCartItems(users, product, byeNum); // 调用添加购物车方法
                            productsController.updateStock(product.getProduct_id(), byeNum);
                            System.out.println("输入Y进入购物车,其它继续购买:");
                            String inputStr = scan.next();
                            if (inputStr != null && inputStr.trim().equals("Y")) {
                                showcartitems(users);
                            }
                        } else if (inputNum == 3) {
                            System.out.println("退出购物!");
                            isLoop = false; // 退出循环
                        } else {
                            System.out.println("输入有误！");
                        }
                    } else { // 库存不足或者输入数量有误
                        System.out.println("库存不足!请重新选择商品购买....");
                    }
                } else {
                    System.out.println("你购买商品已下架!重新选择购买!");
                }
            } else {
                System.out.println("你输入商品编号错误！请重新操作:");
            }
        }
    }


    public static void showcartitems(Users users) {
        boolean isLoop = true;

        while (isLoop) {
            Cart_itemsController controller = new Cart_itemsController();
            List<Cart_items> list = controller.showAllcart_items(users.getUser_id());
            System.out.println("+------------+--------------+--------+------------+------------+");
            System.out.println("|  商品ID    | 商品名称      | 数量   | 单价 (元)   | 总价 (元)   |");
            System.out.println("+------------+--------------+--------+------------+------------+");

            for (Cart_items item : list) {
                System.out.printf("| %-10d | %-12s | %-6d | %-10.2f | %-10.2f |\n",
                        item.getProduct_id(),
                        item.getProduct_name(),
                        item.getQuantity(),
                        item.getPrice(),
                        item.getTotal_price());
            }

            System.out.println("+------------+--------------+--------+------------+------------+");

            System.out.println("********购物车页面*************");
            System.out.println("********1.修改购物车指定商品数量*************");
            System.out.println("********2.删除指定商品*************");
            System.out.println("********3.购物车商品结算*************");
            System.out.println("********4.退   出*************");
            System.out.println("*********请选择输入:************");
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.println("请选择需要修改数量的商品编号");
                    int id = scan.nextInt();
                    System.out.println("请输入修改数量");
                    int count = scan.nextInt();
                    controller.updatequantities(count, id, users.getUser_id());
                    break;
                case 2:
                    System.out.println("请选择需要删除的商品编号");
                    id = scan.nextInt();
                    Cart_items cartItems = new Cart_items(null, users.getUser_id(), id, null, null);
                    controller.deleteBycart_item_id(cartItems);
                    break;
                case 3:

                    //生成订单
                    if (list != null && list.size() > 0) {
                        Map<String, Object> map = new HashMap<>();
                        map = generateOrderandOrderItems(users, controller, list);
                        //付款
                        pay(users, (int) map.get("pid"),list);
                    }

                    //清空用户购物车
                    for (Cart_items c : list
                    ) {
                        controller.deleteBycart_item_id(c);
                    }
                    break;
                case 4:
                    System.out.println("成功退出!");
                    isLoop = false;
                    break;
                default:
                    System.out.println("输入有误!");
                    break;
            }
        }

    }

    private static Map<String, Object> generateOrderandOrderItems(Users users, Cart_itemsController controller, List<Cart_items> list) {
        double total = controller.sumall(users.getUser_id());
        int orderid = ordersController.addorder(users.getUser_id(), total);
        for (Cart_items c : list
        ) {
            ordersController.addorderitem(orderid, c.getProduct_id(), c.getQuantity(), c.getPrice());
        }
        System.out.println("请选择支付方式");
        scan.nextLine();
        String payment_method = scan.nextLine();
        String transition_id = IDUtils.randomId();
        int pid = paymentController.addPayment(orderid, payment_method, total, transition_id);

        Map<String, Object> result = new HashMap<>();
        result.put("pid", pid);

        return result;

    }

    public static void insertCartItems(Users users, Products product, int byeNum) {
        //根据商品编号查询购物车中是否存在商品
        Cart_items items = controller.getCartItemsByPidAndUid(product.getProduct_id(), users.getUser_id());
        if (items != null) {
            controller.updatequantities(items.getCart_item_id(), byeNum, users.getUser_id());//修改购车中指定商品数量
        } else {
            //创建购车对象并封装数据
            Cart_items cartItems = new Cart_items(null, users.getUser_id(), product.getProduct_id(), byeNum, null);
            //实现新增购物车信息
            controller.addCartitem(cartItems);
        }


    }


    public static void pay(Users users, int pid,List<Cart_items> list) {

        double totalMoney = controller.sumall(users.getUser_id());
        if (users.getMoney() > totalMoney) {
            //修改用户余额
            userController.changeMoney(users, totalMoney);
            System.out.println("付款成功");

            //修改payment状态需要pid
            paymentController.changeStatus("completed", pid);
            //打印订单(知道pid可以知道对应订单)
            printOrderMsg(paymentController.findOid(pid),list);

        } else {
            System.out.println("付款失败");
            paymentController.changeStatus("failed", pid);
        }

    }

    //还是要订单号
    public static void printOrderMsg(Integer order_id,List<Cart_items> list) {
        //1.根据当前订单查询订单详情(包括订单信息 和 关联订单商品信息 )
        //调用controller层方法查询数据
        Orders order = ordersController.selctByoid(order_id);
        System.out.println("订单号:" + order.getOrder_id());
        System.out.println("--------------------订单详情--------------------------");
        System.out.println("\t\t商品编号\t\t\t商品名称\t\t\t单价\t\t\t购买数量");
        //遍历商品信息

            for (Cart_items item : list) {
                System.out.println("\t\t" + item.getProduct_id() + "\t\t\t" + item.getProduct_name() + "\t\t\t"
                        + item.getPrice() + "\t\t\t" + item.getQuantity());
            }
        }

}
