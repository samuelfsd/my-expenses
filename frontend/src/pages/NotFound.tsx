import { Link } from "react-router-dom";

export const NotFound = () =>  {
  return (
    <div className="flex h-[100dvh] flex-col items-center justify-center bg-gray-100 px-4 dark:bg-gray-950">
      <div className="space-y-4 text-center">
        <h1 className="text-9xl font-bold tracking-tighter text-gray-900 dark:text-gray-50">404</h1>
        <p className="text-xl font-medium text-gray-500 dark:text-gray-400">
          Oops, a página que você estava procurando não existe.
        </p>
        <Link
          className="inline-flex h-10 items-center justify-center rounded-md bg-gray-900 px-6 text-sm font-medium text-gray-50 shadow transition-colors hover:bg-gray-900/90 focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-gray-950 disabled:pointer-events-none disabled:opacity-50 dark:bg-gray-50 dark:text-gray-900 dark:hover:bg-gray-50/90 dark:focus-visible:ring-gray-300"
          to="/"
        >
          Volte para a página de Login.
        </Link>
      </div>
    </div>
  )
}