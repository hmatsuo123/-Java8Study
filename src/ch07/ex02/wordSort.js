/* 起動：jjs wordSort.js */
var JPaths = java.nio.file.Paths;
var JFiles = java.nio.file.Files;
var JStandardCharsets = java.nio.charset.StandardCharsets;
var JArrays = java.util.Arrays;
var JString = java.lang.String;

var words = new JString(JFiles.readAllBytes(JPaths.get("../../../../resources/WarAndPeace.txt")), JStandardCharsets.UTF_8);
var result = JArrays.asList(words.split(/[\W]+/)).stream()
  .filter(function(word) word.length() > 12)
  .map(function(word) word.toLowerCase())
  .distinct()
  .sorted();

result.forEach(function(word) print(word));