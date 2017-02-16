/* 起動：jjs class.js */

var word = 'qwertyuiop@['
print("Literal: " + word.getClass());
var substr = word.substr(0, 5);
print("substr:  " + substr.getClass());
var cast = java.lang.String.class.cast(substr);
print(cast);
print("cast:  " + cast.getClass());