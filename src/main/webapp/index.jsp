<%--
  User: tobiaswadseth
  Date: 2020-11-27
--%>
<%@ page import="se.iths.grupp2.zoo.animals.Animal" %>
<%@ page import="se.iths.grupp2.zoo.Main" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ZooGame v0</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/styles.css">
    <script src="https://kit.fontawesome.com/215fcec735.js" crossorigin="anonymous"></script>
</head>
<body>
<h1>ZooGame v0!</h1>

<select name="animal-dropdown" class="animal-dropdown form-select">
    <option value="" disabled selected>Select animal</option>
    <optgroup label="Birds">
        <option value="Eagle" data-animal="Eagle">Eagle</option>
        <option value="Ostrich" data-animal="Ostrich">Ostrich</option>
        <option value="Pigeon" data-animal="Pigeon">Pigeon</option>
    </optgroup>
    <optgroup label="Apes">
        <option value="Gorilla" data-animal="Gorilla">Gorilla</option>
        <option value="Orangutan" data-animal="Orangutan">Orangutan</option>
        <option value="Chimpanzee" data-animal="Chimpanzee">Chimpanzee</option>
    </optgroup>
    <optgroup label="Feline">
        <option value="Cat" data-animal="Cat">Cat</option>
        <option value="Lion" data-animal="Lion">Lion</option>
    </optgroup>
    <optgroup label="Fish">
        <option value="Shark" data-animal="Shark">Shark</option>
        <option value="Goldfish" data-animal="Goldfish">Goldfish</option>
    </optgroup>
    <optgroup label="Canine">
        <option value="Wolf" data-animal="Wolf">Wolf</option>
        <option value="Coyote" data-animal="Coyote">Coyote</option>
        <option value="Dog" data-animal="Dog">Dog</option>
    </optgroup>


</select>
<button class="add-animal btn btn-primary">Add Animal</button>
<a href="./settings.jsp" class="settings btn btn-primary" role="button">Settings</a>
<button class="save btn btn-success">Save</button>

<div class="animal-wrapper d-flex flex-row flex-wrap justify-content-center align-items-center"></div>

<div class="alert-wrapper d-flex flex-column-reverse pe-none"></div>

<div class="modal fade" id="confirmRemove" tabindex="-1" aria-labelledby="confirmRemoveLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmRemoveLabel">Confirm</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure you want to remove the <span></span>?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary close-btn-confirmation" data-bs-dismiss="modal">Cancel
                </button>
                <button type="button" class="btn btn-danger remove-btn-confirmation" data-animal>Remove</button>
            </div>
        </div>
    </div>
</div>

<button class="btn btn-dark dark-mode"><i class="fas fa-moon"></i></button>

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

        let removeBtn = document.createElement('button');
        removeBtn.classList.add('btn', 'btn-close', 'btn-remove');
        removeBtn.setAttribute('data-bs-toggle', 'modal');
        removeBtn.setAttribute('data-bs-target', '#confirmRemove')

        let cardImg = document.createElement('img');
        cardImg.classList.add('card-img-top');
        cardImg.src = './assets/images/' + animal + '.png';

        let cardBody = document.createElement('div');
        cardBody.classList.add('card-body');

        let cardTitle = document.createElement('h5');
        cardTitle.classList.add('card-title');
        cardTitle.innerText = animal;

        let foodDropdown = document.createElement('select');
        foodDropdown.classList.add('card-food-dropdown', 'form-select');
        foodDropdown.setAttribute('data-animal', animal);

        let defaultOption = document.createElement('option');
        defaultOption.disabled = true;
        defaultOption.selected = true;
        defaultOption.setAttribute('value', '');
        defaultOption.innerText = 'Select food';

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

        foodDropdown.appendChild(defaultOption);
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
        card.appendChild(removeBtn);
        card.appendChild(cardImg);
        card.appendChild(cardBody);

        cardFeed.addEventListener('click', (e) => {
            let animal = e.target.getAttribute('data-animal');
            let food = $('.card-food-dropdown[data-animal="' + animal + '"]').val();
            if (!food) {
                return;
            }
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
                    } else if (animal === 'Shark') {
                        createAlert('success', 'Shark: Thank you for feeding me, soon I\'ll be big enough to eat you');
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
                    } else if (animal === 'Shark') {
                        createAlert('success', 'Shark: Really, you tried petting a shark? You just lost an arm');
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

        removeBtn.addEventListener('click', (e) => {
            let parentCard = e.target.parentNode;
            let animal = parentCard.getAttribute('data-animal');
            $('.remove-btn-confirmation').attr('data-animal', animal);
            $('.modal-body span').text(animal);
        });

        wrapper.appendChild(card);
    }

    animalList.forEach(animal => {
        createAnimalElem(animal);
    });


    $('.save').click(() => {
        $.post('./save', {}, () => {
            createAlert('success', 'The game has been saved!')
        })
    });
    $('.add-animal').click(() => {
        let animal = $('.animal-dropdown').val();
        if (!animal) {
            return;
        }
        $.post('./add', {animal: animal}, data => {
            if (data === 'success') {
                createAnimalElem(animal);
                createAlert('success', animal + ' has been added!');
            } else {
                createAlert('danger', animal + ' could not be added!');
            }
        });
    });

    $('.remove-btn-confirmation').click(e => {
        let animal = e.target.getAttribute('data-animal');
        $.post('./delete', {animal: animal}, data => {
            if (data === 'success') {
                e.target.setAttribute('data-animal', '');
                document.querySelector('.close-btn-confirmation').click();
                $('.card[data-animal="' + animal + '"]').remove();
                createAlert('success', animal + ' has been deleted!');
            }
        });
    });

    $('.dark-mode').click(() => {
        $('body').toggleClass('dark');
        $('.dark-mode').toggleClass('btn-dark');
        $('.dark-mode').toggleClass('btn-light');
        $('.dark-mode i').toggleClass('fa-moon');
        $('.dark-mode i').toggleClass('fa-sun');
    })
</script>
</body>
</html>
