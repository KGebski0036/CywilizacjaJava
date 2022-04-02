function load(){
    var waterBar = document.getElementById("waterBar");
    var foodBar = document.getElementById("foodBar");
    var woodBar = document.getElementById("woodBar");
    var stoneBar = document.getElementById("stoneBar");
    var goldBar = document.getElementById("goldBar");

    var {size} = foodBar.dataset;
    foodBar.style.width = `${size}%`;

    var {size} = waterBar.dataset;
    waterBar.style.width = `${size}%`;

    var {size} = woodBar.dataset;
    woodBar.style.width = `${size}%`;

    var {size} = stoneBar.dataset;
    stoneBar.style.width = `${size}%`;

    var {size} = goldBar.dataset;
    goldBar.style.width = `${size}%`;
}

window.onload = load;

function TownHailClicked()
{
    ShowHelperWindow("Town hall", "townhail.png", "Zbudowanie twierdzy pozwoli na zbudowanie innych budowli oraz zwiększenie maksymalnej liczby zasobów.");
}
function CloseHelperWindow()
{
    var window = document.getElementById("additionalWindow");
    window.style.display = "none";
}
function ShowHelperWindow(title, img, text){
    var window = document.getElementById("additionalWindow");
    var titleEl = document.getElementById("WindowTitle");
    var imgEl = document.getElementById("ViewImgScr");
    var textEl = document.getElementById("TextInWindow");

    titleEl.innerText = title;
    imgEl.src = "image//buildings/" + img;
    textEl.innerText = text;
    window.style.display = "block";
}