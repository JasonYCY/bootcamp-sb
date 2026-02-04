let autoInterval = null // Stores the timer ID

window.onload = function () {
  addFilter()
}

function addFilter() {
  var coinFilter = document.getElementById('coinFilter')
  var coinRows = document.querySelectorAll('.coinRow')

  coinFilter.addEventListener('input', function () {
    var filter = coinFilter.value.toUpperCase()

    coinRows.forEach(function (row) {
      var coinId = row.id.toUpperCase()

      if (coinId.indexOf(filter) > -1) {
        row.style.display = '' // Show the row
      } else {
        row.style.display = 'none' // Hide the row
      }
    })
  })
}

function toggleAutoUpdate() {
  const autoBtn = document.getElementById('toggleAutoButton')
  const autoStatus = document.getElementById('autoStatus')

  if (autoInterval) {
    // STOP Logic
    clearInterval(autoInterval)
    autoInterval = null

    // Toggle UI via Classes
    autoBtn.textContent = 'Start Auto-Refresh'
    autoBtn.classList.remove('btn-active')
    autoStatus.textContent = 'Auto-Refresh: OFF'
    autoStatus.classList.remove('status-on')
  } else {
    // START Logic
    reloadCoins() // Immediate call
    autoInterval = setInterval(reloadCoins, 5000)

    // Toggle UI via Classes
    autoBtn.textContent = 'Stop Auto-Refresh'
    autoBtn.classList.add('btn-active')
    autoStatus.textContent = 'Auto-Refresh: ON (Every 5s)'
    autoStatus.classList.add('status-on')
  }
}

async function reloadCoins() {
  const status = document.getElementById('status')
  const body = document.getElementById('coinBody')
  const btn = document.getElementById('refreshButton')

  status.textContent = 'Loading Coins ...'
  btn.disabled = true

  try {
    const controller = new AbortController()
    const timeoutId = setTimeout(() => controller.abort(), 5000)

    const response = await fetch('/refresh', { signal: controller.signal })
    clearTimeout(timeoutId)

    if (!response.ok) throw new Error('Network response was not ok')
    const coins = await response.json()

    body.innerHTML = ''

    if (!coins || coins.length === 0) {
      body.innerHTML = '<tr><td colspan="4">No Coins Found.</td></tr>'
      status.textContent = 'Load Completed. No Data.'
      return
    }

    coins.forEach((coinData) => {
      // 1. Handle Price Change Logic (Symbol, Color Class, and Absolute Value)
      const pc = coinData.price_change_percentage_24h
      let changeClass = 'price-unchanged'
      let symbol = ''

      if (pc > 0) {
        changeClass = 'price-up'
        symbol = '⮝ '
      } else if (pc < 0) {
        changeClass = 'price-down'
        symbol = '⮟ '
      }

      const absPc = Math.abs(pc).toFixed(2)

      // 2. Format Numbers (Current Price and Market Cap)
      const formattedPrice = new Intl.NumberFormat('en-US', {
        minimumFractionDigits: 3,
        maximumFractionDigits: 3,
      }).format(coinData.current_price)

      const formattedMarketCap = new Intl.NumberFormat('en-US').format(
        coinData.market_cap,
      )

      // 3. Format Date (YYYY-MM-DD HH:mm:ss)
      const date = new Date(coinData.last_updated)
      const formattedDate =
        date.getFullYear() +
        '-' +
        String(date.getMonth() + 1).padStart(2, '0') +
        '-' +
        String(date.getDate()).padStart(2, '0') +
        ' ' +
        String(date.getHours()).padStart(2, '0') +
        ':' +
        String(date.getMinutes()).padStart(2, '0') +
        ':' +
        String(date.getSeconds()).padStart(2, '0')

      // 4. Construct Row (Matching your exact HTML structure)
      const row = `
          <tr class="coinRow" id="${coinData.id}">
            <td class="col-coin">
              <div class="coin-info">
                <img src="${coinData.image}" alt="Coin Image" height="30" />
                <div class="coin-name-wrapper">
                  <span class="coin-name">${coinData.name}</span>
                  <span class="coin-symbol dark-green-text">${coinData.symbol.toUpperCase()}</span>
                </div>
              </div>
              <div class="coin-updated">
                <span>${formattedDate}</span>
                <span>HKT</span>
              </div>
            </td>

            <td class="col-price dark-green-text">$${formattedPrice}</td>

            <td class="col-change ${changeClass}">${symbol}${absPc}%</td>

            <td class="col-marketcap dark-green-text">$${formattedMarketCap}</td>
          </tr>
        `
      body.insertAdjacentHTML('beforeend', row)
    })

    setTimeout(() => {
      status.textContent = `Loaded ${coins.length} coins`
    }, 1000)
  } catch (error) {
    setTimeout(() => {
      status.textContent = 'Error loading data: ' + error.message
      console.error('Fetch Error:', error)
    }, 1000)
  } finally {
    setTimeout(() => {
      btn.disabled = false
    }, 1000)
    addFilter() // Re-initialize filter for new rows
    document.getElementById('coinFilter').dispatchEvent(new Event('input'))
  }
}
