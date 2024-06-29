import { Link, useLocation } from 'react-router-dom'

import { Captions, Landmark, LayoutDashboard, LogOut } from 'lucide-react'
import { Button } from './ui/button'

export function Sidebar() {
  const location = useLocation()

  const getLinkClass = (path: string) => {
    const isActive = location.pathname === path
    return `flex items-center w-full justify-start gap-3 px-6 py-2 text-sm font-medium transition-colors ${
      isActive
        ? 'bg-muted text-foreground'
        : 'text-muted-foreground hover:bg-muted hover:text-foreground'
    }`
  }

  return (
    <div className="fixed inset-y-0 left-0 z-10 flex h-screen w-64 flex-col border-r bg-background">
      <div className="flex h-16 shrink-0 items-center border-b px-6">
        <div className="flex items-center gap-2 font-semibold">
          <h3 className="scroll-m-20 text-2xl font-semibold tracking-tight">
            Minhas finanças
          </h3>
        </div>
      </div>
      <nav className="flex flex-1 flex-col items-center justify-center overflow-auto py-4">
        <Link to="/" className={getLinkClass('/')}>
          <LayoutDashboard />
          Dashboard
        </Link>
        <Link
          to="/centro-de-custo"
          className={getLinkClass('/centro-de-custo')}
        >
          <Landmark />
          Centro de Custo
        </Link>
        <Link to="/titulos" className={getLinkClass('/titulos')}>
          <Captions />
          Títulos
        </Link>
      </nav>
      <div className="flex items-center justify-center gap-2 font-semibold border-t p-4">
        <Button className="flex items-center">
          <LogOut />
          <h3 className="scroll-m-20 text-2xl font-semibold tracking-tight ml-2">
            Sair
          </h3>
        </Button>
      </div>
    </div>
  )
}
