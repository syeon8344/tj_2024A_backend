/* // 복습예제1 : 1차점수, 2차점수를 받아 총점이 150 이상이면 성공, 아니면 실패, HTML <h3>에 출력
let first= Number(prompt('1차점수: ')); let second= Number(prompt('2차점수: '))
let result= first + second >= 150 ? '성공' : '실패'; console.log(result);
//document.write(`<h3>${result}</h3>`);
let html = `결과: ${result}`;
console.log(document.querySelector('#result'));
document.querySelector('#result').innerHTML= html; */

//복습예제2 : 두 사람 이름, 이름이 '유재석'이면 (방장)을 이름 뒤에 연결, HTML <ol>에 두 이름 <li> 출력
let name1= prompt('첫 번째 이름: '); let name2= prompt('두 번째 이름: ');
console.log(name1, name2);
name1 = name1 == '유재석' ? `${name1}(방장)` : name1;
name2 = name2 == '유재석' ? `${name2}(방장)` : name2;
// document.write(`<ol><li>${name1}</li><li>${name2}</li></ol>`);
document.querySelector('#name1').innerHTML=name1;
let name2HTML = document.querySelector('#name2');
name2HTML.innerHTML = name2;


