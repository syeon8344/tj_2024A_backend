let date = new Date();
let year = date.getFullYear();
let month = date.getMonth();

document.querySelector("#year").innerHTML = year;
document.querySelector('#month').innerHTML = (month+1);

let maxDate = new Date(year, month+1, 0).getDate(); // 현재 달의 말일날짜
let startWeek = new Date(year, month, 1).getDay(); // 현재 달 첫날 요일

let calendar = [] //console.log()
let clickedNum = 0 //메모시 누른 날짜
// {월 : 1, 일 : 1, 요일 : 월요일}, 일 ~ 토 : 0 ~ 6
// 1월
let week = 0;
let contentList = []


cal(month);
calendarPrint();

function cal(month){
    calendar = [];
    week = Number(startWeek);
    for (let i = 0; i < maxDate; i++) { // 1월, 31일 루프
        let date = { month : 0, day : 0, week : 0}
        date.month = month; date.day = (i+1); date.week = week;
        calendar.push(date);
        week++;
        if (week == 7) {week = 0}
        
    }

}
// 월 바뀌면 월에 맞는 달력 재출력
function calendarPrint(){
    let tableHTML = '';
    let monthStart = 0;
    let tableWeek = 0;
    let daysWrote = 0;
    let cMonth = Number(document.querySelector('#month').innerHTML)
    cal(cMonth);
    for (let i = 0; i < 42; i++){
        if (monthStart == 0 && calendar[0].week == i) {monthStart = 1;} // 달력 날짜 시작
        
        if (monthStart == 1 && daysWrote == calendar.length) {monthStart = 2;} // 달력 날짜 끝
        if (monthStart == 0 || monthStart == 2){ // 달력 날짜 외
            tableHTML += tableWeek == 0 ? `<tr><td></td>` : tableWeek == 6 ? `<td></td></tr>` : `<td></td>`
        } else { // 달력 날짜들
            tableHTML += tableWeek == 0 ? `<tr><td onclick="schedule(${daysWrote+1})"><p id="letter${daysWrote+1}">${calendar[daysWrote].day}</p><div id="d${daysWrote+1}" class="memoTxt"></div></td>` : tableWeek == 6 ? `<td onclick="schedule(${daysWrote+1})"><p id="letter${daysWrote+1}">${calendar[daysWrote].day}</p><div id="d${daysWrote+1}" class="memoTxt"></div></td></tr>` : `<td onclick="schedule(${daysWrote+1})"><p id="letter${daysWrote+1}">${calendar[daysWrote].day}</p><div id="d${daysWrote+1}" class="memoTxt"></div></td>`
            daysWrote++;
        }
        tableWeek++;
        if (tableWeek == 7){tableWeek = 0};
    }
    document.querySelector("tbody").innerHTML = tableHTML
    contentPrint();
}

function contentPrint(){ // 메모 반영
    let html = ''
    for (let i = 0; i < contentList.length; i++) {
        if (contentList[i].year == year && contentList[i].month == month+1 && contentList[i].day == document.querySelector(`#letter${contentList[i].day}`).innerHTML) {
            html = `<div id="memo" style="background-color: ${contentList[i].color}">${contentList[i].content}</div>`
        }
        document.querySelector(`#d${contentList[i].day}`).innerHTML += html;
        html = '';
    }
}

function changeMonth(num){
    let shownMonth = month + 1
    if (num == -1) { // 저번 달
        if (shownMonth >= 2) {
            document.querySelector('#month').innerHTML = Number(shownMonth - 1)
        } else if (shownMonth == 1) {document.querySelector("#year").innerHTML = Number(year - 1); document.querySelector('#month').innerHTML = 12}
    }
    if (num == 1) { // 다음 달
        if (shownMonth <= 11) {
            document.querySelector('#month').innerHTML = Number(shownMonth + 1)
        } else if (shownMonth == 12) {document.querySelector("#year").innerHTML = Number(year + 1); document.querySelector('#month').innerHTML = 1}
    }
    month = Number(document.querySelector('#month').innerHTML - 1)
    year = Number(document.querySelector("#year").innerHTML)
    maxDate = new Date(year, month+1, 0).getDate();
    startWeek = new Date(year, month, 1).getDay();
    calendarPrint();
}

function schedule(num){ // 메모 추가
    clickedNum = num;
    document.querySelector("#wrap").style.cssText = "z-index: 1; background-color: white; opacity: 0.3;"
    document.querySelector("#schedulePopUp").style.cssText = `z-index: 2; display: flex; position: fixed; top:30vh; right:35vw;
                                                            background-color: white;
                                                            flex-direction: column; flex-wrap: wrap; align-content: center; align-items: center;
                                                            text-align: center;
                                                            height: 300px; width: 400px;
                                                            border: 1px solid grey; border-radius: 30px;`
    calendarPrint();
}

//2024-05-07
function writeMemo(){
    let memoContent = document.querySelector("#memoContent").value  
    console.log(memoContent)
    let date = document.querySelector("#memoDate").value
    let splitDate = date.split('-')
    let memoYear = Number(splitDate[0]);
    let memoMonth = Number(splitDate[1]);
    let memoDay = Number(splitDate[2]);
    let memoColor = document.querySelector("#memoColor").value
    contentList.push({year : memoYear, month : memoMonth, day : memoDay, content : memoContent, color : memoColor })
    console.log(contentList)

    document.querySelector("#memoContent").value = ''
    document.querySelector("#wrap").style.cssText = ''
    document.querySelector("#schedulePopUp").style.cssText = 'display: none'
    calendarPrint();
}

//http://192.168.30.186:5500/day16/2_과제3.html