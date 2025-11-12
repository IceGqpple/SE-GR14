//Header komponent med logo og ikoner for videre funksjonalitet
export default function Header() {
    return (
        <header className="header">
            <div className="Header_inner">
                <div className="Logo">Ruteplaneren
                </div>
                <div className="header_actions">
                    <button className="icon-btn" title="Bytt språk">🇳🇴</button>
                    <div className="header_login">
                        <span className="checkmark">✓</span>
                        <span>Norsk</span>
                        <span>Login</span>
                    </div>
                    <button className="icon-btn" title="Søk">🔍</button>
                    <span className="header_search_text">Søk</span>
                </div>
            </div>
        </header>
    );
}



