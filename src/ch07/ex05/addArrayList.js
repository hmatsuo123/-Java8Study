/* 起動：jjs addArrayList.js */
function createArrayList() {
  var arr =  new (Java.extend(java.util.ArrayList)) {
    add: function(x) {
      print('Adding ' + x);
      return Java.super(arr).add(x);
    }
  }
  return arr;
}
var arr = createArrayList();
arr.add("123");
arr.add("456");
print(arr);
var arr2 = createArrayList();
arr2.add("abc");
print(arr2);