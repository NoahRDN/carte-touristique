function setupFilters() {
  const paysSelect = document.getElementById("pays");
  const villeSelect = document.getElementById("ville");
  const typeSelect = document.getElementById("type");

  fetch("/api/countries")
    .then(res => res.json())
    .then(paysList => {
      paysList.forEach(pays => {
        const opt = document.createElement("option");
        opt.value = pays.code;
        opt.innerText = pays.nom;
        paysSelect.appendChild(opt);
      });
    });

  paysSelect.addEventListener("change", () => {
    const paysCode = paysSelect.value;
    const paysNom = paysSelect.options[paysSelect.selectedIndex].text;

    villeSelect.innerHTML = '<option value="" disabled selected>-- Choose a city --</option>';
    villeSelect.disabled = true;

    fetch(`/api/cities?pays=${encodeURIComponent(paysCode)}`)
      .then(res => res.json())
      .then(villes => {
        villeSelect.disabled = false;
        villes.forEach(ville => {
          const opt = document.createElement("option");
          opt.value = ville.nom;
          opt.innerText = ville.nom;
          villeSelect.appendChild(opt);
        });
      });

    chargerEtAfficherLieux(paysNom, "", typeSelect.value);
  });

  villeSelect.addEventListener("change", () => {
    const paysNom = paysSelect.options[paysSelect.selectedIndex].text;
    const ville = villeSelect.value;
    chargerEtAfficherLieux(paysNom, ville, typeSelect.value);
  });

  typeSelect.addEventListener("change", () => {
    const paysNom = paysSelect.options[paysSelect.selectedIndex].text;
    const ville = villeSelect.value;
    chargerEtAfficherLieux(paysNom, ville, typeSelect.value);
  });
}
