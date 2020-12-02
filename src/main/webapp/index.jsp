<%--
  User: tobiaswadseth
  Date: 2020-11-27
--%>
<%@ page import="se.iths.grupp2.animals.Core" %>
<%@ page import="se.iths.grupp2.animals.Animal" %>
<%@ page import="se.iths.grupp2.animals.Main" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ZooGame v0</title>
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
    <h1>ZooGame v0!</h1>

    <div class="animal-wrapper">
    </div>

    <script>
        const wrapper = document.querySelector('.animal-wrapper');
        wrapper.innerHTML = '';
        // let animalList = ['Crow', 'Eagle'];
        let animalList = [];

        <% for (Animal animal : Main.getController().getAnimals()) { %>
            console.log("<%=animal.getName()%>");
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
            container.appendChild(interactBtns);
            container.appendChild(viewBtn);
            wrapper.appendChild(container);
        });
    </script>
    <script src="assets/js/main.js"></script>
</body>
</html>
