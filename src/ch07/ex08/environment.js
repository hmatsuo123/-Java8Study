/* 起動：jjs -scripting environment.js */

for (var key in $ENV) {
  print(key + '=' + $ENV[key]);
}