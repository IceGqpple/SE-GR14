import Header from './components/Header';
import Footer from './components/Footer';
import NewsSidebar from './components/NewsSidebar';
import Search from './components/Search';
import CardLink from './components/CardLink';
import './App.scss';


export default function App() {
      /**Holder det enkelt med fragment og divs :) */
  return (
    <>
      <Header />
      <div className="shell">
        <main className="grid">
          <section className="left">
            <Search />
          </section>

          <section className="center">
            <div className="card-grid">
              <CardLink title="Se ruter" subtitle="Ruter for buss, tog & ferger" icon="→" />
              <CardLink title="Driftsmeldinger" subtitle="Info om trasportsmidler & systemer" icon="⚠" />
              <CardLink title="Billetter" subtitle="Typer billetter & priser" icon="🎟️" />
              <CardLink title="Nyttig informasjon" subtitle="Les mer om oss!" icon="🛈" />
            </div>
          </section>

          <section className="right">
            <NewsSidebar />
          </section>
        </main>
      </div>
      <Footer />
    </>
  )
}
