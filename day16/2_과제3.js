let calendar = [] //console.log()
let dayperMonth = [31,29,31,30,31,30,31,31,30,31,30,31] // 월마다 날짜
let weekperMonth = [1,4,5,1,3,6,1,4,0,2,5,0] // 월 시작 요일
// {월 : 1, 일 : 1, 요일 : 월요일}, 일 ~ 토 : 0 ~ 6
// 1월
let week = 0;
for (let i = 0; i < 12; i++) { // 개월 루프
    calendar[i] = [];
    week = weekperMonth[i];
    for (let j = 0; j < dayperMonth[i]; j++) { // 1월, 31일 루프
        let date = { month : 0, day : 0, week : 0}
        date.month = i; date.day = (j+1); date.week = week;
        calendar[i].push(date);
        week++;
        if (week == 7) {week = 0}
        
    }
}

calendarPrint();


// 월 바뀌면 월에 맞는 달력 재출력
function calendarPrint(){
    let tableHTML = '';
    let monthStart = 0;
    let tableWeek = 0;
    let daysWrote = 0;
    let currentMonth = Number(document.querySelector('#month').innerHTML - 1)
    console.log(currentMonth)
    console.log(calendar[5])
    for (let i = 0; i < 42; i++){
        let curC = calendar[currentMonth]
        if (monthStart == 0 && curC[0].week == i) {monthStart = 1} // 달력 날짜 시작
        if (monthStart == 1 && daysWrote == curC.length) {monthStart = 2} // 달력 날짜 끝
        if (monthStart == 0 || monthStart == 2){ // 달력 날짜 외
            tableHTML += tableWeek == 0 ? `<tr><td></td>` : tableWeek == 6 ? `<td></td></tr>` : `<td></td>`
            console.log(tableHTML)
        } else { // 달력 날짜들
            tableHTML += tableWeek == 0 ? `<tr><td id=calendar${i}><p>${curC[daysWrote].day}</p></td>` : tableWeek == 6 ? `<td id=calendar${i}><p>${curC[daysWrote].day}</p></td></tr>` : `<td id=calendar${i}><p>${curC[daysWrote].day}</p></td>`
            daysWrote++; console.log(daysWrote)
            console.log(tableHTML)
        }
        tableWeek++;
        if (tableWeek == 7){tableWeek = 0};
    }
    document.querySelector("tbody").innerHTML = tableHTML
}

function prevMonth(){
    let month = Number(document.querySelector('#month').innerHTML)
    if (month > 1) {
        document.querySelector('#month').innerHTML = month - 1
    }
    calendarPrint();
}
function nextMonth(){
    let month = Number(document.querySelector('#month').innerHTML)
    if (month < 12) {
        document.querySelector('#month').innerHTML = month + 1
    }
    calendarPrint();
}