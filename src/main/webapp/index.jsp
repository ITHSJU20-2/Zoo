<%--
  User: tobiaswadseth
  Date: 2020-11-27
--%>
<%@ page import="se.iths.grupp2.animals.Animal" %>
<%@ page import="se.iths.grupp2.animals.Main" %>
<%@ page import="java.util.UUID" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ZooGame v0</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<h1>ZooGame v0!</h1>

<select name="animal-dropdown" class="animal-dropdown">
    <option value="Eagle" data-animal="Eagle">Eagle</option>
    <option value="Ostrich" data-animal="Ostrich">Ostrich</option>
    <option value="Pigeon" data-animal="Pigeon">Pigeon</option>
    <option value="Gorilla" data-animal="Gorilla">Gorilla</option>
    <option value="Orangutan" data-animal="Orangutan">Orangutan</option>
    <option value="Chimpanzee" data-animal="Chimpanzee">Chimpanzee</option>
</select>
<button class="add-animal">Add Animal</button>
<button class="save">Save</button>
<a href="./settings.jsp" class="settings">Settings</a>

<div class="animal-wrapper d-flex flex-row flex-wrap"></div>

<div class="alert-wrapper d-flex flex-column-reverse"></div>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
        integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
        crossorigin="anonymous"></script>
<script>
    const wrapper = document.querySelector('.animal-wrapper');
    wrapper.innerHTML = '';
    let animalList = [];

    <% for (Animal animal : Main.getController().getAnimals()) { %>
    animalList.push("<%= animal.getName() %>");
    <% } %>

    const createAlert = (type, text) => {
        const uuid = '<%=UUID.randomUUID().toString()%>';
        const alertElem = document.createElement('div');
        alertElem.id = uuid;
        alertElem.classList.add('alert', 'alert-' + type, 'alert-dismissible', 'fade', 'show');
        alertElem.innerHTML =
            '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' + text;

        document.querySelector('.alert-wrapper').appendChild(alertElem);

        setTimeout(() => {
            $('#' + uuid).alert('close');
        }, 5000);
    }

    const createAnimalElem = (animal) => {
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

        feedBtn.addEventListener('click', (e) => {
            let animal = e.target.getAttribute('data-animal');
            let food = $('.food-dropdown[data-animal="' + animal + '"]').val();
            $.post('./feed', {animal: animal, food: food}, data => {
                if (data === 'success') {
                    createAlert('success', animal + ' has been fed with ' + food + '!');
                } else if (data === 'error') {
                    createAlert('danger', animal + ' does not like ' + food + '!');
                }
            });
        });

        petBtn.addEventListener('click', (e) => {
            let animal = e.target.getAttribute('data-animal');
            $.post('./pet', {animal: animal}, data => {
                if (data === 'success') {
                    createAlert('success', animal + ' has been pet!');
                } else {
                    createAlert('danger', animal + ' does not like to be touched there!');
                }
            });
        });

        wrapper.appendChild(container);
    }

    animalList.forEach(animal => {
        createAnimalElem(animal);
    });


    $('.save').click(e => {
        $.post('./save', {}, () => {
            createAlert('success', 'The game has been saved!')
        })
    });
    $('.add-animal').click(() => {
        let animal = $('.animal-dropdown').val();
        $.post('./add', {animal: animal}, data => {
            if (data === 'success') {
                createAnimalElem(animal);
                createAlert('success', animal + ' has been added!');
            } else {
                createAlert('danger', animal + ' could not be added!');
            }
        });
    });
</script>
</body>
</html>
