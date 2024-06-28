import { Sidebar } from '@/components/Sidebar'

export const Home = () => {
  return (
    <div className="grid grid-cols-[16rem_1fr] gap-4">
      <Sidebar />

      <main>content</main>
    </div>
  )
}
