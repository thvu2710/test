import { useWeb3React } from "@web3-react/core"
import { useEffect } from "react"
import { injected } from "../components/wallet/connectors"

export default function Home() {
  const { active, account, library, connector, activate, deactivate } = useWeb3React()



  function isMobileDevice() {
    return 'ontouchstart' in window || 'onmsgesturechange' in window
  }

  async function checkIfWalletIsConnected() {
    if (!(window.web3 || window.ethereum)) {
        if (isMobileDevice()) {
            const dappUrl = 'nextjs-rmd.vercel.app/'
            const metamaskAppDeepLink = 'https://metamask.app.link/dapp/' + dappUrl

            window.location.href = metamaskAppDeepLink
        } else {
            window.open('https://metamask.io/download/', '_blank')
        }
    } else {
        await connect()
    }
}
  async function connect() {
    try {
      await activate(injected)
    } catch (ex) {
      console.log(ex)
    }
  }

  async function disconnect() {
    try {
      deactivate()
    } catch (ex) {
      console.log(ex)
    }
  }

  useEffect(() => {
    const connectWalletOnPageLoad = async () => {
      await checkIfWalletIsConnected()
    }
    connectWalletOnPageLoad()
  }, [])

  return (
    <div className="flex flex-col items-center justify-center">
      <button onClick={connect} className="py-2 mt-20 mb-4 text-lg font-bold text-white rounded-lg w-56 bg-blue-600 hover:bg-blue-800">Connect to MetaMask</button>
      {active ? <span>Connected with <b>{account}</b></span> : <span>Not connected</span>}
      <button onClick={disconnect} className="py-2 mt-20 mb-4 text-lg font-bold text-white rounded-lg w-56 bg-blue-600 hover:bg-blue-800">Disconnect</button>
    </div>
  )
}
