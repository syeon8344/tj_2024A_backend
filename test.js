myPlot();

function myPlot(){
    const xArray = ["1반", "2반", "3반", "4반", "5반", "6반"];
    const yArray = [85, 79, 84, 74, 75, 87];

    const data = [{
    x:xArray,
    y:yArray,
    type:"bar",
    orientation:"v",
    marker: {color:"rgba(0,0,255,0.6)"}
    }];

    const layout = {title:"3월 모의고사 평균"};

    Plotly.newPlot("myPlot", data, layout);
}