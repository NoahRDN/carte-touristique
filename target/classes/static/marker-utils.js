let markers = [];

function clearMarkers() {
  markers.forEach(marker => marker.setMap(null));
  markers = [];
}

function addMarker(lieu) {
  const iconUrl = `/images/${lieu.type || "default"}.svg`;

  const marker = new google.maps.Marker({
    position: { lat: lieu.latitude, lng: lieu.longitude },
    map: map,
    title: lieu.nom,
    icon: {
      url: iconUrl,
      scaledSize: new google.maps.Size(40, 40)
    }
  });

  const infoWindow = new google.maps.InfoWindow({
    content: `
      <div>
        <strong>${lieu.nom}</strong><br/>
        <p>${lieu.description || ''}</p>
        ${lieu.siteWeb ? `<a href="${lieu.siteWeb}" target="_blank">Website</a>` : ''}
      </div>
    `
  });

  marker.addListener("click", () => {
    infoWindow.open(map, marker);
  });

  markers.push(marker);
}
