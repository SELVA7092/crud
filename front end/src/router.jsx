import { createBrowserRouter, RouterProvider } from "react-router-dom"
import { Empty, Home } from "./pages/Home"
import Register from "./pages/Register"

const router = createBrowserRouter([
    {
        path:"/",
        element:<Home />,
        children:[
            {
                path:"/",
                element:<Empty />
            },
            {
                path:"/register",
                element:<Register />
            }
        ]
    }
])

export function MyRouter(){
    return <RouterProvider router={router} />
}