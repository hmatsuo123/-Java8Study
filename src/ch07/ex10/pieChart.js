/* 起動：jjs -fx pieChart.js */

var JString = java.lang.String;
var JPaths = java.nio.file.Paths;
var JFiles = java.nio.file.Files;
var JStandardCharsets = java.nio.charset.StandardCharsets;
var JFXCollections = javafx.collections.FXCollections;
var JPieChart = javafx.scene.chart.PieChart;

var contents = new JString(JFiles.readAllBytes(JPaths.get("data.json")), JStandardCharsets.UTF_8);
var data = JSON.parse(contents);
var list = [];
for (var n in data.list) {
  var key = data.list[n].key;
  var value = data.list[n].value;
  list[n] = new JPieChart.Data(key, value);
}
var chart = new JPieChart(JFXCollections.observableArrayList(list));

$STAGE.scene = new javafx.scene.Scene(chart);
$STAGE.title = "pieChart Sample";