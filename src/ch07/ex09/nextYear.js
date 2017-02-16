/* 起動：jjs -scripting nextYear.js -- 24
 *       jjs -scripting nextYear.js */

var JSystem = java.lang.System;
var JScanner = java.util.Scanner;

function printYear(year) {
	print("Next year, you will be " + year + ".");
}

if (arguments.length == 1) {
	printYear(arguments[0] - - 1);
} else if ("AGE" in $ENV) {
	printYear(($ENV.AGE - - 1));
} else {
  while(true) {
	  print("あなたの年齢を入力してください: ");
	  var scanner = new JScanner(JSystem.in);
	  if (scanner.hasNextInt()) {
	    var age = scanner.nextInt();
	    printYear((age + 1));
	    break;
	  } else {
		  print("入力が不正です");
	  }
  }
}