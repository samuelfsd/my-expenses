import { Sidebar } from '@/components/dashboard/Sidebar'

export const Home = () => {
  return (
    <div className="grid grid-cols-[16rem_1fr] gap-4">
      <Sidebar
        paths={[
          {
            href: '/',
            label: 'Tarefas',
          },
        ]}
      />

      <main>content</main>
    </div>
  )
}
