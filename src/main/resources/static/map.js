let map;

function chargerEtAfficherLieux(paysNom, ville, type) {
  clearMarkers();

  const params = new URLSearchParams();
  if (paysNom) params.append('pays', paysNom);
  if (ville) params.append('ville', ville);
  if (type) params.append('type', type);

  fetch(`/api/lieux?${params.toString()}`)
    .then(res => res.json())
    .then(lieux => {
      if (!paysNom && !ville && !type) {
        map.setCenter({ lat: 0, lng: 0 });
        map.setZoom(2);
      } else if (ville && villeCoords[ville]) {
        map.panTo(villeCoords[ville]);
        map.setZoom(12);
      } else if (paysNom && paysCoords[paysNom]) {
        map.panTo(paysCoords[paysNom]);
        map.setZoom(6);
      }

      lieux.forEach(lieu => addMarker(lieu));

      if (lieux.length > 0 && !ville && !paysNom) {
        const bounds = new google.maps.LatLngBounds();
        lieux.forEach(lieu => bounds.extend({ lat: lieu.latitude, lng: lieu.longitude }));
        map.fitBounds(bounds);

        google.maps.event.addListenerOnce(map, "bounds_changed", function () {
          if (map.getZoom() > 15) map.setZoom(15);
        });
      }
    })
    .catch(err => console.error("Erreur lors du chargement des lieux :", err));
}

function initMap() {
  const mapTypeSelect = document.getElementById("mapType");

  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 0, lng: 0 },
    zoom: 2,
    mapTypeId: mapTypeSelect.value
  });

  mapTypeSelect.addEventListener("change", () => {
    map.setMapTypeId(mapTypeSelect.value);
  });

  setupFilters();
}
