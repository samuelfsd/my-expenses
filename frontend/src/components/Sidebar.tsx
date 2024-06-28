import { Link } from 'react-router-dom'

import { Captions, Landmark, LayoutDashboard } from 'lucide-react'

export function Sidebar() {
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
        <Link
          to="#"
          className="flex items-center w-full justify-start gap-3 px-6 py-2 text-sm font-medium text-muted-foreground transition-colors hover:bg-muted hover:text-foreground"
        >
          <LayoutDashboard />
          Dashboard
        </Link>
        <Link
          to="#"
          className="flex items-center w-full justify-start gap-3 px-6 py-2 text-sm font-medium text-muted-foreground transition-colors hover:bg-muted hover:text-foreground"
        >
          <Landmark />
          Centro de Custo
        </Link>
        <Link
          to="#"
          className="flex items-center w-full justify-start gap-3 px-6 py-2 text-sm font-medium text-muted-foreground transition-colors hover:bg-muted hover:text-foreground"
        >
          <Captions />
          Títulos
        </Link>
      </nav>
    </div>
  )
}
