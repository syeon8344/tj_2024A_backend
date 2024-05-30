printList();

function printList(){
    let listHTML = '';
    let listStyle = '';
    let textStyle = '';

    tList = JSON.parse(localStorage.getItem("todoList"));
    if (tList == null) {tList = []; localStorage.setItem("todoList", JSON.stringify(tList));}


    for (let i = 0; i < tList.length; i++) {
        if (tList[i].mode == 0) {
            listStyle = `style= "font-weight: bold; background-color: white;"`
            textStyle = `style= "text-decoration-line: none; color: black;"`
        } else {
            listStyle = `style= "font-weight: bold; background-color: black;"`
            textStyle = `style= "text-decoration-line: line-through; color: white"`
        }
        
        listHTML += `<li id="list${tList[i].num}" ${listStyle}>
                    <p id="text${tList[i].num}" ${textStyle}>${tList[i].text}</p>
                    <div>
                        <button type="button" onclick="modeChange(${tList[i].num})">변경</button>
                        <button type="button" onclick="itemDelete(${tList[i].num})">삭제</button>
                    </div>
                    </li>`
    }
    document.querySelector('#list').innerHTML = listHTML;
}


function upload() {

    tList = JSON.parse(localStorage.getItem("todoList"));
    lNum = JSON.parse(localStorage.getItem("listNum"));
    if (lNum == null) {lNum = 0;}
    
    let newItem = {num: lNum, text : '', mode : 0 };
    newItem.text = document.querySelector('#item').value;

    tList.push(newItem);
    lNum++;

    localStorage.setItem("todoList", JSON.stringify(tList));
    localStorage.setItem("listNum", JSON.stringify(lNum));

    printList();
}


function modeChange(index) {
    tList = JSON.parse(localStorage.getItem("todoList"));

    for (let i = 0; i < tList.length; i++) {
        if (tList[i].num == index) {
            if (tList[i].mode == 0) {
                tList[i].mode = 1
            } else {
                tList[i].mode = 0
            }
        }
    }

    localStorage.setItem("todoList", JSON.stringify(tList));

    printList();
}

function itemDelete(index) {
    tList = JSON.parse(localStorage.getItem("todoList"));

    for (let i = 0; i < tList.length; i++) {
        if (tList[i].num == index) {
            tList.splice(i,1)
        }
    }

    localStorage.setItem("todoList", JSON.stringify(tList));

    printList();
}
