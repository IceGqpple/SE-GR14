//Enkel kort komponent som fungerer som en lenke

type Props = { title: string; subtitle: string; icon?: string; href?: string; description?: string; };

export default function CardLink({ title, subtitle, icon }: Props) {
    return (
        <button className="card" type="button">
            {icon && <div className="card_icon">{icon}</div>}
            <div className="card_title">{title}</div>
            <div className="card_subtitle">{subtitle}</div>
        </button>
    );
}   
