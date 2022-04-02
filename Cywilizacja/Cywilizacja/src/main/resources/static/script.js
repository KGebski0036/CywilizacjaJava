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

var currentBuilding;
var currentImg;
var currentWatherCost;
var currentFoodCost;

function TownHailClicked()
{
    ShowHelperWindow("TownHall", "townhail.png", "Zbudowanie twierdzy pozwoli na zbudowanie innych budowli oraz zwiększenie maksymalnej liczby zasobów.");
    currentWatherCost = -20;
    currentFoodCost = -20;
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

    currentBuilding = title;
    currentImg = img;

    titleEl.innerText = title;
    imgEl.src = "image//buildings/" + img;
    textEl.innerText = text;
    window.style.display = "block";
}
function BuildBilding(){
    var building = document.getElementById(currentBuilding);
    building.style.backgroundImage = "url('image/buildings/townhail.png')";
    building.children[0].innerText = "";
    CloseHelperWindow();
}