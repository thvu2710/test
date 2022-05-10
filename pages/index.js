import React from 'react'
import { useWeb3React } from "@web3-react/core";
import { useEffect, useState } from 'react'
import { injected } from "../components/wallet/connectors";

export default function Home() {
  const { active, account, library, connector, activate, deactivate } = useWeb3React();

  const [currentNetwork, setCurrentNetwork] = useState(null)


  function isMobileDevice() {
    return "ontouchstart" in window || "onmsgesturechange" in window;
  }

  async function changeNetwork() {
    try {
        await ethereum.request({
            method: 'wallet_switchEthereumChain',
            params: [{ chainId: '0x13881' }],
        })
        setCurrentNetwork('80001')
    } catch (err) {
        console.error('Change Network Error', err)
        // Not added chain network
        if (err.code === 4902 || err.code === -32603) {
            try {
                await ethereum.request({
                    method: 'wallet_addEthereumChain',
                    params: [
                        {
                            chainName: 'Polygon Testnet',
                            chainId: '0x13881',
                            blockExplorerUrls: ['https://mumbai.polygonscan.com/'],
                            rpcUrls: ['https://matic-mumbai.chainstacklabs.com'],
                            nativeCurrency: {
                                name: 'MATIC',
                                symbol: 'MATIC', // 2-6 characters long
                                decimals: 18,
                            },
                        },
                    ],
                })
                await activate(injected);
            } catch (err) {
                console.error('Wallet Add error', err)
            }
        }
    }
}

  async function checkIfWalletIsConnected() {
    debugger
    if (!(window.web3 || window.ethereum)) {
      debugger
      if (isMobileDevice()) {
        const dappUrl = "test-git-master-thvu2710.vercel.app/";
        const metamaskAppDeepLink = "https://metamask.app.link/dapp/" + dappUrl;

        window.location.href = metamaskAppDeepLink;
      } else {
        window.open("https://metamask.io/download/", "_blank");
      }
    } else if ((window.web3 || window.ethereum) && currentNetwork && currentNetwork !== "80001") {
      debugger
      changeNetwork();
    } else {
      debugger
      await connect();
    }
  }
  async function connect() {
    try {
      debugger
      await activate(injected);
    } catch (ex) {
      console.log(ex);
    }
  }

  async function disconnect() {
    try {
      deactivate();
    } catch (ex) {
      console.log(ex);
    }
  }

  useEffect(() => {
    // alert("BEFORE RUN")

    const connectWalletOnPageLoad = async () => {
      // alert("RUN")
      await checkIfWalletIsConnected();
    };
    connectWalletOnPageLoad();
  }, []);

  return (
    <div className="flex flex-col items-center justify-center">
      <button
        onClick={connect}
        className="py-2 mt-20 mb-4 text-lg font-bold text-white rounded-lg w-56 bg-blue-600 hover:bg-blue-800"
      >
        Connect to MetaMask
      </button>
      {active ? (
        <span>
          Connected with <b>{account}</b>
        </span>
      ) : (
        <span>Not connected</span>
      )}
      <button
        onClick={disconnect}
        className="py-2 mt-20 mb-4 text-lg font-bold text-white rounded-lg w-56 bg-blue-600 hover:bg-blue-800"
      >
        Disconnect
      </button>
    </div>
  );
}
