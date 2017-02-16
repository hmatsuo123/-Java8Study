/* 実行結果
jjs> var b = new java.math.BigInteger('1234567890987654321')
jjs> b
1234567890987654400
jjs> b.mod(java.math.BigInteger.TEN)
1
*/

/* 起動：jjs bigInterger.js */

var JBigInteger = java.math.BigInteger;
var JString = java.lang.String;

var b = new JBigInteger('1234567890987654321');
print("b Class: " + typeof b);
//print(Java.to(b, JBigInteger));
print(JString.valueOf(b.longValue()));

print("Java mod:" + JString.valueOf(b.mod(JBigInteger.TEN).longValue()));