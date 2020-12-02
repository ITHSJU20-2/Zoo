const test = () => {
    $('.feed-btn').each(function() {
        $(this).click(() => {
            let animal = $(this).attr('data-animal');
            let food = 'Vegetable';
            feed(animal, food);
        })
    });
    $('.pet-btn').each(function() {
        $(this).click(() => {
            let animal = $(this).attr('data-animal');
            pet(animal);
        })
    });
}

test();

const feed = (animal, food) => {
    $.post('./feed', { animal: animal, food: food }, data => {
        if (data === 'success') {
            console.log(`${animal} has been fed with ${food}`);
        } else {
            console.log(`${animal} does not like ${food}`);
        }
    });
}

const pet = (animal) => {
    $.post('./pet', { animal: animal }, data => {
        if (data === 'success') {
            console.log(`${animal} has been pet`);
        } else {
            console.log(`${animal} does not like to be touched there`);
        }
    });
}