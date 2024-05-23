let todoList = []

/* function uploadItem() {
    let item = document.querySelector('#item').value;
    let html = ''
    for (i=0; i<todoList.length; i++) {
        html += `<li id="list${i}" style="background-color: #FFFFFF; font-weight: bold; text-decoration-line: none;>
                    <span>${todoList[i]}</span>
                    <div>
                        <button onclick="changeStyle()">변경</button>
                        <button onclick="itemDelete(${i})">삭제</button>
                    </div>
                </li>`
    }
    document.querySelector("#").innerHTML = html
} */

function uploadItem() {
    todoList.push(document.querySelector('#item').value)
    let index = todoList.length -1
    let html = document.querySelector("#list").innerHTML
    html += `<li id="list${index}" style="background-color: #FFFFFF; font-weight: bold;>
                <span>${todoList[index]}</span>
                <div>
                    <button onclick="changeStyle(${index})">변경</button>
                    <button onclick="itemDelete(${index})">삭제</button>
                </div>
            </li>`
    document.querySelector("#list").innerHTML = html
}

function changeStyle(x) {
    let color = document.getElementById(`#list${x}`).style.backgroundColor
    if (color == "#FFFFFF") {
        document.getElementById(`#list${x}`).style.backgroundColor = "#000000"
        document.getElementById(`#list${x}`).style.textDecorationLine = "line-through"
    }
    if (color == "#000000") {
        document.getElementById(`#list${x}`).style.backgroundColor = "#FFFFFF"
        document.getElementById(`#list${x}`).style.textDecorationLine = "none"
    }
}

function itemDelete(x) {
    document.getElementById(`list${todoList[x]}`).remove()
}
