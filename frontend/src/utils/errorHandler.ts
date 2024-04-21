import { toast } from "@/components/ui/use-toast"

// eslint-disable-next-line @typescript-eslint/no-explicit-any
export const errorHandler = (error: any) => {
  if (error.response) {
    if (error.response.data.message.search(':') === -1) {
      toast({
        variant: "destructive",
        title: "Erro",
        description: error.response.data.message
      })
    }
    const errorLabel = error.response.data.message.split(':')
    toast({
      variant: "destructive",
      title: "Erro",
      description: errorLabel
    })
  }
}