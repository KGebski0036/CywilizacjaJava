

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