/* 起動：jjs zonedDataTime.js */

var ZonedDateTime = Java.type('java.time.ZonedDateTime');
var now = ZonedDateTime.now();
print(now);
var nextYear = now.plusYears(1);
print(nextYear);
print(now.zone);