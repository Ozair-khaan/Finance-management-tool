document.getElementById("transaction-form").addEventListener("submit", function (e) {
    e.preventDefault();

    const category = document.getElementById("category").value;
    const amount = document.getElementById("amount").value;
    const type = document.getElementById("type").value;

    const transaction = { category, amount, type, date: new Date() };

    fetch("http://localhost:8080/api/transactions/add", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(transaction),
    })
        .then((response) => response.text())
        .then((data) => {
            alert(data);
            loadTransactions();
        });
});

function loadTransactions() {
    fetch("http://localhost:8080/api/transactions/user/1") // Replace with the logged-in user ID
        .then((response) => response.json())
        .then((transactions) => {
            const list = document.getElementById("transaction-list");
            list.innerHTML = "";
            transactions.forEach((t) => {
                const li = document.createElement("li");
                li.textContent = `${t.category} - $${t.amount} (${t.type})`;
                list.appendChild(li);
            });
        });
}

loadTransactions();
