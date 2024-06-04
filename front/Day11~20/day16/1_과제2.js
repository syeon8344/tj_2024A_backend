let todoList = []; //console.log()
let listNum = 0;
function upload() {
    let newItem = {num: listNum, text : '', mode : 0 };
    newItem.text = document.querySelector('#item').value;
    todoList.push(newItem);
    listNum++;
    console.log(todoList)
    printList();
}


function printList(){
    let listHTML = '';
    let listStyle = '';
    let textStyle = '';
    for (let i = 0; i < todoList.length; i++) {
        if (todoList[i].mode == 0) {
            listStyle = `style= "font-weight: bold; background-color: white;"`
            textStyle = `style= "text-decoration-line: none; color: black;"`
        } else {
            listStyle = `style= "font-weight: bold; background-color: black;"`
            textStyle = `style= "text-decoration-line: line-through; color: white"`
        }
        
        listHTML += `<li id="list${todoList[i].num}" ${listStyle}>
                    <p id="text${todoList[i].num}" ${textStyle}>${todoList[i].text}</p>
                    <div>
                        <button type="button" onclick="modeChange(${todoList[i].num})">변경</button>
                        <button type="button" onclick="itemDelete(${todoList[i].num})">삭제</button>
                    </div>
                    </li>`
    }
    document.querySelector('#list').innerHTML = listHTML;
}

function modeChange(index) {
    for (let i = 0; i < todoList.length; i++) {
        if (todoList[i].num == index) {
            if (todoList[i].mode == 0) {
                todoList[i].mode = 1
            } else {
                todoList[i].mode = 0
            }
        }
    }
    printList();
}

function itemDelete(index) {
    for (let i = 0; i < todoList.length; i++) {
        if (todoList[i].num == index) {
            todoList.splice(i,1)
        }
    }
    printList();
}
