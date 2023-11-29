$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/groups/mafalda/user",
        method: "GET",
        success: function (data) {
            $("#group-list").empty();
            for (var i = 0; i < data.length; i++) {
                var group = data[i];
                $("#group-list").append(`
                    <li>
                        <a href="#" class="clearfix" onclick="toggleSelection(this, ${group.gid})">
                            <div class="friend-name">
                                <strong>${group.groupName}</strong>
                            </div>
                        </a>
                    </li>
                `);
            }
        },
        error: function (error) {
            console.error("Erro ao obter a lista de grupos:", error);
        }
    });
});

function toggleSelection(element, gid) {
    // Remova a classe 'selected-group' de todos os elementos da lista
    $("#group-list li a").removeClass("selected-group");

    // Adicione a classe 'selected-group' apenas ao elemento clicado
    $(element).addClass("selected-group");

    // Atualize o URL da página com base no GID
    window.location.href = `/chat.html?id=${gid}`;
}
