var jsonObj = [
    {
        "name":"Fred",
        "age":23,
        "city":"ohao",
        "country":"China",
        "address":{
        "street":"tianfu 5 st",
        "city":"chengdu",
        "state":"sichuan",
        "zip":"637000",

}
        },
    
    
    
    {
    "name": "John",
    "age": 30,
    "city": "New York",
    "country": "USA",
    "address": {
        "street": "Main St",
        "city": "New York",
        "state": "NY",
        "zip": "10001"
    }
}]

var jsonString = JSON.stringify(jsonObj);


var obj=JSON.parse(jsonString);

alert(jsonString);