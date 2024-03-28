import React from 'react'
import { useParams } from 'react-router-dom'

function StudentStatus(props) {
    const {id, state} = useParams();

  return (
    <div>StudentStatus</div>
  )
}

export default StudentStatus