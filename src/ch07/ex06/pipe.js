/* 起動：jjs -scripting pipe.js -- "cmd /c dir /b /s ..\\..\\*.js" "sort" */

function pipe() {
  var result = "";
  for (i = 0; i < arguments.length; i++) {
    result = $EXEC(arguments[i], result);
  }
  return result;
 }

//print(arguments);
//print(pipe('find .', 'grep -v class', 'sort'));
//print(pipe("cmd /c dir /b /s ..\\..\\*.js", "sort"));