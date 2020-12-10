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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
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
    <option value="Cat" data-animal="Cat">Cat</option>
    <option value="Lion" data-animal="Lion">Lion</option>

</select>
<button class="add-animal btn btn-primary">Add Animal</button>
<a href="./settings.jsp" class="settings btn btn-primary" role="button">Settings</a>
<button class="save btn btn-success">Save</button>

<div class="animal-wrapper d-flex flex-row flex-wrap justify-content-center align-items-center"></div>

<%--<div--%>
<%--        style="background-image:url('./assets/images/Eagle.png');height:200px;width:200px;background-position:center;background-repeat:no-repeat;background-size: contain;border:1px solid #111;border-radius:8px;"></div>--%>

<div class="alert-wrapper d-flex flex-column-reverse pe-none"></div>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
<script>
    const wrapper = document.querySelector('.animal-wrapper');
    wrapper.innerHTML = '';
    let animalList = [];

    <% for (Animal animal : Main.getController().getAnimals()) { %>
    animalList.push("<%= animal.getName() %>");
    <% } %>

    const uuid = () => {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, (c) => {
            let r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
            return v.toString(16);
        });
    }

    const createAlert = (type, text) => {
        const alertId = uuid();
        const alertElem = document.createElement('div');
        alertElem.id = alertId;
        alertElem.classList.add('alert', 'alert-' + type, 'alert-dismissible', 'fade', 'show');
        alertElem.innerHTML =
            text +
            '<button type="button" class="btn-close pe-auto" data-bs-dismiss="alert" aria-label="Close"></button>';

        document.querySelector('.alert-wrapper').appendChild(alertElem);

        setTimeout(() => {
            $('#' + alertId).alert('close');
        }, 5000);
    }

    const createAnimalElem = (animal) => {
        let card = document.createElement('div');
        card.classList.add('card', 'fadeIn', 'animated');
        card.setAttribute('data-animal', animal);

        let cardImg = document.createElement('img');
        cardImg.classList.add('card-img-top');
        cardImg.src = './assets/images/' + animal + '.png';

        let cardBody = document.createElement('div');
        cardBody.classList.add('card-body');

        let cardTitle = document.createElement('h5');
        cardTitle.classList.add('card-title');
        cardTitle.innerText = animal;
        let foodDropdown = document.createElement('select');
        foodDropdown.classList.add('card-food-dropdown');
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

        let cardAnimBtns = document.createElement('div');
        cardAnimBtns.classList.add('d-flex', 'justify-content-between', 'btn-div');

        let cardFeed = document.createElement('button');
        cardFeed.classList.add('btn', 'btn-primary', 'btn-feed', 'w-50');
        cardFeed.setAttribute('data-animal', animal);
        cardFeed.innerText = 'Feed';

        let cardPet = document.createElement('button');
        cardPet.classList.add('btn', 'btn-primary', 'btn-pet', 'w-50');
        cardPet.setAttribute('data-animal', animal);
        cardPet.innerText = 'Pet';

        cardAnimBtns.appendChild(cardFeed);
        cardAnimBtns.appendChild(cardPet);

        let cardView = document.createElement('a');
        cardView.classList.add('btn', 'btn-success', 'w-100');
        cardView.setAttribute('role', 'button');
        cardView.href = './animal/' + animal;
        cardView.innerText = 'View';

        cardBody.appendChild(cardTitle);
        cardBody.appendChild(foodDropdown);
        cardBody.appendChild(cardAnimBtns);
        cardBody.appendChild(cardView);
        card.appendChild(cardImg);
        card.appendChild(cardBody);


        cardFeed.addEventListener('click', (e) => {
            let animal = e.target.getAttribute('data-animal');
            let food = $('.card-food-dropdown[data-animal="' + animal + '"]').val();
            $.post('./feed', {animal: animal, food: food}, data => {
                if (data === 'success') {
                    if (animal === 'Gorilla') {
                        createAlert('success',
                            'Gorilla: I am the strongest of all apes. Admire my mighty growth.');
                    } else if (animal === 'Orangutan') {
                        createAlert('success', 'Orangutan: My arms are a real conversation starter.');
                    } else if (animal === 'Chimpanzee') {
                        createAlert('success',
                            'Chimpanzee: If I grow too big I may become too much to handle...');
                    } else {
                        createAlert('success', animal + ' has been fed with ' + food + '!');
                    }
                } else if (data === 'error') {
                    if (animal === 'Gorilla') {
                        createAlert('warning',
                            'Gorilla: I\'m still puny. And I blame you.');
                    } else if (animal === 'Orangutan') {
                        createAlert('warning', 'Orangutan: Come on man, you know I\'m vegan.');
                    } else if (animal === 'Chimpanzee') {
                        createAlert('warning',
                            'Chimpanzee: I\'m not normally fussy, but your cooking sucks, dude. Everybody is thinking it, I just said it.');
                    } else {
                        createAlert('danger', animal + ' does not want ' + food + '!');
                    }
                }
            });
        });

        cardPet.addEventListener('click', (e) => {
            let animal = e.target.getAttribute('data-animal');
            $.post('./pet', {animal: animal}, data => {
                if (data === 'success') {
                    if (animal === 'Gorilla') {
                        createAlert('success', 'Gorilla: Thank you!');
                    } else if (animal === 'Orangutan') {
                        createAlert('success', 'Orangutan: Awwww, come \'ere you!');
                    } else if (animal === 'Chimpanzee') {
                        createAlert('success',
                            'Chimpanzee: I like you, haven\'t felt this loved since I met Michael Jackson!');
                    } else
                        createAlert('success', animal + ' has been pet!');
                } else if (data === 'error') {
                    if (animal === 'Gorilla') {
                        createAlert('warning',
                            'Gorilla: Dude, really? Petting me? The mighty Gorilla? You got a death wish?!');
                    } else {
                        createAlert('danger', animal + ' does not like to be touched there!');
                    }
                }
            });
        });

        wrapper.appendChild(card);
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
