<%--
  User: tobiaswadseth
  Date: 2020-11-27
--%>
<%@ page import="se.iths.grupp2.animals.Animal" %>
<%@ page import="se.iths.grupp2.animals.Main" %>
<%@ page import="se.iths.grupp2.animals.Ostrich" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ZooGame v0</title>
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<h1>ZooGame v0!</h1>

<button class="add-pigeon">Add Pigeon</button>
<button class="save">Save</button>
<a href="./settings.jsp" class="settings">Settings</a>

<div class="animal-wrapper">
</div>

<script>
    const wrapper = document.querySelector('.animal-wrapper');
    wrapper.innerHTML = '';
    let animalList = [];

    <% for (Animal animal : Main.getController().getAnimals()) { %>
            animalList.push("<%= animal.getName() %>");
        <% } %>

        animalList.forEach(animal => {
            let container = document.createElement('div');
            container.classList.add('animal-container');
            let title = document.createElement('div');
            title.classList.add('animal-title');
            let interactBtns = document.createElement('div');
            interactBtns.classList.add('animal-interact-btns');

            let name = document.createElement('p');
            name.classList.add('animal-name');
            name.innerText = animal;

            let foodDropdown = document.createElement('select');
            foodDropdown.classList.add('food-dropdown');
            foodDropdown.setAttribute('data-animal', animal);

            let vegetableOption = document.createElement('option');
            vegetableOption.setAttribute('value', 'vegetable');
            vegetableOption.innerText = 'Vegetable';

            let fruitOption = document.createElement('option');
            fruitOption.setAttribute('value', 'fruit');
            fruitOption.innerText = 'Fruit';

            let berryOption = document.createElement('option');
            berryOption.setAttribute('value', 'berry');
            berryOption.innerText = 'Berry';

            let meatOption = document.createElement('option');
            meatOption.setAttribute('value', 'meat');
            meatOption.innerText = 'Meat';

            foodDropdown.appendChild(vegetableOption);
            foodDropdown.appendChild(fruitOption);
            foodDropdown.appendChild(berryOption);
            foodDropdown.appendChild(meatOption);

            let feedBtn = document.createElement('button');
            feedBtn.classList.add('btn');
            feedBtn.classList.add('feed-btn');
            feedBtn.innerText = 'Feed';
            feedBtn.setAttribute('data-animal', animal);

            let petBtn = document.createElement('button');
            petBtn.classList.add('btn');
            petBtn.classList.add('pet-btn');
            petBtn.innerText = 'Pet';
            petBtn.setAttribute('data-animal', animal);

            let viewBtn = document.createElement('a');
            viewBtn.classList.add('link-btn');
            viewBtn.classList.add('view-btn');
            viewBtn.innerText = 'View';
            viewBtn.href = 'animal/' + animal;
            viewBtn.setAttribute('data-animal', animal);

            title.appendChild(name);
            interactBtns.appendChild(feedBtn);
            interactBtns.appendChild(petBtn);
            container.appendChild(title);
            container.appendChild(foodDropdown);
            container.appendChild(interactBtns);
            container.appendChild(viewBtn);
            wrapper.appendChild(container);
        });
</script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
    $('.add-pigeon').click(e => {
        $.post('./add', {}, () => {
            console.log("Added Pigeon");
        })
    });
    $('.save').click(e => {
        $.post('./save', {}, () => {
            console.log("Saved");
        })
    });
    $('.feed-btn').each(function () {
        $(this).click(() => {
            let animal = $(this).attr('data-animal');
            let food = $('.food-dropdown[data-animal="' + animal + '"]').val();
            $.post('./feed', {animal: animal, food: food}, data => {
                if (data === 'success') {
                    console.log(animal + ' has been fed with ' + food);
                } else if (data === 'error') {
                    console.log(animal + ' does not like ' + food);
                }
            });
        })
    });
    $('.pet-btn').each(function () {
        $(this).click(() => {
            let animal = $(this).attr('data-animal');
            $.post('./pet', {animal: animal}, data => {
                if (data === 'success') {
                    console.log(animal + ' has been pet');
                } else {
                    console.log(animal + ' does not like to be touched there');
                }
            });
        })
    });
</script>
</body>
</html>
