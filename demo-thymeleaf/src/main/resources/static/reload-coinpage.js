window.onload = function () {
  // reloadCoins()
  console.log('The page has been loaded!')
}

function reloadCoins() {
  const $status = $('#status')
  const $body = $('#coinBody')
  const $btn = $('#refreshButton')

  $status.text('Loading Coins ...')
  $btn.prop('disabled', true)

  $.ajax({
    url: '/refresh',
    method: 'GET',
    dataType: 'json',
    timeout: 5000,
    success: function (coins) {
      $body.empty()
      if (!coins || coins.length === 0) {
        $body.append('<tr><td>No Coins Found.</td></tr>')
        $status.text('Load Completed. No Data.')
        return
      }

      coins.forEach((coinData) => {
        const row = `
          <tr class="coinRow">
            <td>
              <img src="${coinData.image}" alt="Coin Image" height="30" />
            </td>
            <td>${coinData.id}</td>
            <td>${coinData.current_price}</td>
            <td>${formatVolume(coinData.total_volume)}</td>
          </tr>
        `
        $body.append(row)
      })
      $status.text(`Loaded ${coins.length} coins`)
    },
    error: function (xhr, status, error) {
      $status.text(
        'Error loading data: ' + (xhr.responseJSON?.message || error),
      )
      console.error('Ajax Error: ', status, error)
    },
    complete: function () {
      $btn.prop('disabled', false)

      // rebind the eventListener for filtering
      addFilter()
    },
  })
}

function addFilter() {
  var coinFilter = document.getElementById('coinFilter')
  var coinRows = document.querySelectorAll('.coinRow')

  coinFilter.addEventListener('input', function () {
    var filter = coinFilter.value.toUpperCase()

    coinRows.forEach(function (row) {
      var coinId = row
        .querySelector('td:nth-child(2)')
        .textContent.toUpperCase()

      if (coinId.indexOf(filter) > -1) {
        row.style.display = '' // Show the row
      } else {
        row.style.display = 'none' // Hide the row
      }
    })
  })
}

function formatVolume(totalVolume) {
  if (totalVolume === null || totalVolume === undefined) {
    return '0'
  }

  if (totalVolume >= 1_000_000_000) {
    return (totalVolume / 1_000_000_000).toFixed(2) + 'B'
  }

  if (totalVolume >= 1_000_000) {
    return (totalVolume / 1_000_000).toFixed(2) + 'M'
  }

  return totalVolume.toString()
}
