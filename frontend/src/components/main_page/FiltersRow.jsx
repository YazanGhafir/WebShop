import React, { Component } from 'react'
import DropdownButton from 'react-bootstrap/DropdownButton'
import Dropdown from 'react-bootstrap/Dropdown'
import ButtonGroup from 'react-bootstrap/ButtonGroup'

export default class FiltersRow extends Component {
    render() {
        return (
            <div>
                <ButtonGroup>
                    <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-vertical-dropdown-1" variant="light">
                        <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                    </DropdownButton>
                    <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-vertical-dropdown-2" variant="light">
                        <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                    </DropdownButton>
                    <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-vertical-dropdown-3" variant="light">
                        <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                    </DropdownButton>
                    <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-vertical-dropdown-3" variant="light">
                        <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                    </DropdownButton>
                    <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-vertical-dropdown-3" variant="light">
                        <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                    </DropdownButton>
                    <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-vertical-dropdown-3" variant="light">
                        <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                    </DropdownButton>
                    <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-vertical-dropdown-3" variant="light">
                        <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                        <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                    </DropdownButton>
                </ButtonGroup>
            </div>
        )
    }
}
