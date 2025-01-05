$(document).ready(function () {
    const cards = $(".data-card");
    const itemsPerPage = 12;
    let currentPage = 1;
    let filteredCards = cards;

    const noBooksMessage = $("<div class='alert alert-warning text-center'>Nenhum livro encontrado</div>");
    noBooksMessage.css("margin-top", "10px");
    noBooksMessage.hide();
    $("#searchInput").after(noBooksMessage);

    function updatePagination() {
        const startIndex = (currentPage - 1) * itemsPerPage;
        const endIndex = startIndex + itemsPerPage;

        cards.hide();
        filteredCards.slice(startIndex, endIndex).show();

        if (filteredCards.length === 0) {
            noBooksMessage.show();
        } else {
            noBooksMessage.hide();
        }
    }

    function setupPaginationControls() {
        const totalPages = Math.ceil(filteredCards.length / itemsPerPage);
        const paginationContainer = $("#pagination");

        paginationContainer.empty();

        for (let i = 1; i <= totalPages; i++) {
            const pageButton = $(`<button class="btn btn-sm mx-1 ${i === currentPage ? 'btn-primary' : 'btn-outline-primary'}">${i}</button>`);
            pageButton.on("click", function () {
                currentPage = i;
                setupPaginationControls();
                updatePagination();
            });
            paginationContainer.append(pageButton);
        }

        paginationContainer.toggle(totalPages > 1);
    }

    setupPaginationControls();
    updatePagination();

    $("#searchInput").on("keyup", function () {
        const searchValue = $(this).val().toLowerCase();

        filteredCards = cards.filter(function () {
            const card = $(this);
            const cardText = card.text().toLowerCase();
            return cardText.includes(searchValue);
        });

        currentPage = 1;
        setupPaginationControls();
        updatePagination();
    });
});
