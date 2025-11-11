//Sidebar som viser siste nyheter og hendelser relatert til reiser

export default function NewsSidebar() {
    const items = [
        {when: "NÅ:", title: "Ulykke på E6", image: "⚠"},
        {when: "NÅ:", title: "Store togforsinkelser", image: "🚆"},
        {when: "I natt", title: "Glatte veier", image: "🌨️"}
    ];
    return (
        <aside className="news-sidebar">
            <div className="news_title">Siste hendelser</div>
            <ul className="news_list">
                {items.map((n, i) => (
                    <li key={i} className="news_item">
                        <div className="news_image">{n.image}</div>
                        <div className="news_content">
                            <div className="news_badge">{n.when}</div>
                            <div className="news_text">{n.title}</div>
                        </div>
                    </li>
                ))}
            </ul>
            <button className="news_all" type="button" onClick={() => alert("Kommer snart:P")}>Se alle hendelser</button>
        </aside>
    );
}
