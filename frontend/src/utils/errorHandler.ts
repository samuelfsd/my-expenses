import { toast } from "@/components/ui/use-toast"

type Error = {
  response: {
    data: {
      message: string;
    }
  };
}

export const errorHandler = (error: Error) => {
  if (error.response) {
      toast({
        variant: "destructive",
        title: "Erro",
        description: error.response.data.message
      })
  }
}