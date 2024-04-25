import { toast } from "@/components/ui/use-toast"

// eslint-disable-next-line @typescript-eslint/no-explicit-any
export const errorHandler = (error: any) => {
  if (error.response) {
      toast({
        variant: "destructive",
        title: "Erro",
        description: error.response.data.message
      })
  }
}