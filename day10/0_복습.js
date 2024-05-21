/*  학습 예제 1: 주차장 차량 검색대
    조건 1. let carArray = ['24나5644', '12무2233']
    조건 2. let locArray = ['B2', 'C3']
    조건 3. carArray, locArray 인덱스가 같다= 같은 차량 정보
    조건 4. 차량 번호를 입력받아 차량 위치 찾기

let carArray = ['24나5644', '12무2233'];
let locArray = ['B2', 'C3'];

let carNum = prompt('차량 번호를 입력: ');
carIndex = carArray.indexOf(carNum);
if (carIndex == -1) {'차량이 없습니다'}
    else {
        let carLocation = locArray[carIndex]
        console.log(`차의 위치는 ${carLocation}`)};

    복습 에제 2: 틱택토/삼목게임
        - 설계 : 9칸 판넬 필요, 9칸 배열 생성
        - 패널 상태 : ''(비어있음) O (P1) X (P2)
        - 승리 체크
            1. 가로: [0]==[1]==[2], 3 4 5, 6 7 8
            2. 세로: 0 3 6, 1 4 7, 2 5 8
            3. 대각선: 0 4 8, 2 4 6

*/
let gamePanel = ['','','','','','','','','',]

gamePanel[5] = "O";

let HTML = `${gamePanel[0]} ${gamePanel[1]} ${gamePanel[2]} <br/>
            ${gamePanel[3]} ${gamePanel[4]} ${gamePanel[5]} <br/>
            ${gamePanel[6]} ${gamePanel[7]} ${gamePanel[8]}`

document.querySelector('#gamePanel').innerHTML = HTML;

// 1. P1 입력 2. 승리 체크 3. P2 입력 4. 승리 체크 -> 무승부까지 (공백이 없다)

if (gamePanel[0] != '' && (gamePanel[0]==gamePanel[1] && gamePanel[1]==gamePanel[2])) { }
if (gamePanel[0] != '' && (gamePanel[3]==gamePanel[4] && gamePanel[4]==gamePanel[5])) { }
if (gamePanel[0] != '' && (gamePanel[6]==gamePanel[7] && gamePanel[7]==gamePanel[8])) { }

if (gamePanel[0] != '' && (gamePanel[0]==gamePanel[3] && gamePanel[3]==gamePanel[6])) { }
if (gamePanel[0] != '' && (gamePanel[1]==gamePanel[4] && gamePanel[4]==gamePanel[7])) { }
if (gamePanel[0] != '' && (gamePanel[2]==gamePanel[5] && gamePanel[5]==gamePanel[8])) { }

if (gamePanel[0] != '' && (gamePanel[0]==gamePanel[1] && gamePanel[1]==gamePanel[2])) { }
if (gamePanel[0] != '' && (gamePanel[0]==gamePanel[1] && gamePanel[1]==gamePanel[2])) { }

