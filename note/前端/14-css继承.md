## css继承

css继承：父元素的样式默认子元素可以获取到

- 自动继承:子元素不需要任何操作，可以自动从父元素上获取对应的样式作用在子标签上

- 手动继承：子元素需要设置对应的代码，让指定的属性从父标签上获取该属性的值

  `css属性名：inherit`:inherit代表从父元素上继承该css属性的值

### 1.可以被子元素自动继承的css属性

- font系列字体样式可以被自动继承
  - font-size
  - font-famil
  - font-weight
  - font-style
- 文本样式可以被继承
  - color
  - text-align
  - word-spacing
  - letter-spacing
  - text-transform
  - text-indent

### 2.不可以被自动继承的css属性

background，width，height